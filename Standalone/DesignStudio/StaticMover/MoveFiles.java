package Standalone.DesignStudio.StaticMover;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;

@SuppressWarnings("StringTemplateMigration")
public class MoveFiles {

    public static void main(String[] args) throws IOException {

        String zohoCreatorDir = "/Users/harish-10327/Downloads/Test";
        String staticSrcDir = "/Users/harish-10327/Downloads/Test/creator";
        String buildLabel = "12002292";

        ImageMovement(zohoCreatorDir, staticSrcDir, buildLabel);
    }

    private static void ImageMovement(String zohoCreatorDir, String staticSrcDir, String buildLabel) throws IOException {

        PrintStream out = System.out;
        out.println("Initiated relocation of images to static folder, Start Time ::: " + System.currentTimeMillis());

        Path coreSrc    = Paths.get(zohoCreatorDir, "designstudio/core/assets/v1/images");
        Path moduleSrc  = Paths.get(zohoCreatorDir, "designstudio/modules/portal/assets/v1/images");
        Path sharedSrc  = Paths.get(zohoCreatorDir, "designstudio/shared/assets/v1/images");
        Path destBase   = Paths.get(staticSrcDir, buildLabel, "appbuilder/images/designstudio");

//        if (!Files.isDirectory(destBase)) {
//            System.out.println("Destination directory missing: " + destBase);
//            return;
//        }

        // -----------------------
        // USE CASE 1: CORE
        // -----------------------
        if (Files.isDirectory(coreSrc)) {

            System.out.println("Running core image movement...");

            moveFolder(coreSrc.resolve("common"), destBase.resolve("com"));
            moveFlattenedFiles(coreSrc.resolve("components"), destBase.resolve("cmp"));

            deleteFolder(coreSrc.resolve("common"));
            deleteFolder(coreSrc.resolve("components"));
        }

        // -----------------------
        // USE CASE 2: MODULES/PORTAL
        // -----------------------
        if (Files.isDirectory(moduleSrc)) {

            System.out.println("Running modules/portal image movement...");

            Path moduleDest = destBase.resolve("m_pl");
            Files.createDirectories(moduleDest);

            moveFlattenedFiles(moduleSrc.resolve("components"), moduleDest.resolve("cmp"));
            moveTemplates(moduleSrc.resolve("templates"), moduleDest);

            deleteFolder(moduleSrc.resolve("components"));
            deleteFolder(moduleSrc.resolve("templates"));
        }

        // -----------------------
        // USE CASE 3: SHARED
        // -----------------------
        if (Files.isDirectory(sharedSrc)) {

            System.out.println("Running shared assets movement...");
            moveSharedAssets(sharedSrc, destBase);
        }
    }

    // --------------------------
    // TEMPLATES LOGIC
    // --------------------------
    private static void moveTemplates(Path templatesSrc, Path moduleRoot) throws IOException {
        if (!Files.exists(templatesSrc)) return;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(templatesSrc)) {
            for (Path folder : stream) {

                if (!Files.isDirectory(folder)) continue;

                String name = folder.getFileName().toString();
                Path target;

                if (name.equalsIgnoreCase("Default")) {
                    target = moduleRoot.resolve("td");
                } else if (name.startsWith("ZP_")) {
                    String number = name.substring(3).replaceFirst("^0+", "");
                    if (number.isEmpty()) number = "1";
                    target = moduleRoot.resolve("t" + number);
                } else {
                    target = moduleRoot.resolve(name);
                }

                moveFolder(folder, target);
            }
        }
    }

    // --------------------------
    // SHARED ASSETS LOGIC
    // --------------------------
    private static void moveSharedAssets(Path sharedSrc, Path destBase) throws IOException {
        if (!Files.exists(sharedSrc)) return;

        Path sdRoot = destBase.resolve("sd");
        Files.createDirectories(sdRoot);

        // default/ → flatten into sd/default/
        Path defaultSrc = sharedSrc.resolve("default");
        Path defaultDest = sdRoot.resolve("default");
        if (Files.exists(defaultSrc)) {
            moveFlattenedFiles(defaultSrc, defaultDest);
            deleteFolder(defaultSrc);
        }

        // design/ → all subfolders directly under sd/
        Path designSrc = sharedSrc.resolve("design");
        if (Files.exists(designSrc)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(designSrc)) {
                for (Path folder : stream) {
                    if (Files.isDirectory(folder)) {
                        Path target = sdRoot.resolve(folder.getFileName());
                        moveFolder(folder, target);
                    }
                }
            }
            deleteFolder(designSrc);
        }

        // category/ → numbered mapping (1_name → c1) or name-based (motorsport → cmotorsport)
        Path categorySrc = sharedSrc.resolve("category");
        if (Files.exists(categorySrc)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(categorySrc)) {

                for (Path folder : stream) {
                    if (!Files.isDirectory(folder)) continue;

                    String folderName = folder.getFileName().toString();
                    Path target;

                    // CASE 1: starts with number + underscore → c<number>
                    if (folderName.matches("^\\d+_.*")) {
                        String number = folderName.substring(0, folderName.indexOf('_')).trim();
                        target = sdRoot.resolve("c" + number);

                    } else {
                        // CASE 2: plain name → c<name>
                        target = sdRoot.resolve("c" + folderName);
                    }

                    moveFolder(folder, target);
                }
            }

            deleteFolder(categorySrc);
        }
    }

    // --------------------------
    // FLAT FILE MOVE UTILITY
    // (Generic, reusable)
    // --------------------------
    private static void moveFlattenedFiles(Path src, Path dest) throws IOException {
        if (!Files.exists(src)) return;

        Files.createDirectories(dest);

        Files.walk(src)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    try {
                        String fileName = file.getFileName().toString();
                        Path target = dest.resolve(fileName);

                        if (Files.exists(target)) {
                            throw new RuntimeException(
                                    "Duplicate file name detected during flattening: " + fileName +
                                            " (Source: " + file + ", Existing: " + target + ")"
                            );
                        }

                        Files.copy(file, target);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    // --------------------------
    // REGULAR FOLDER COPY
    // --------------------------
    private static void moveFolder(Path src, Path dest) throws IOException {
        if (!Files.exists(src)) return;

        Files.createDirectories(dest);

        Files.walk(src).forEach(path -> {
            try {
                Path target = dest.resolve(src.relativize(path));

                if (Files.isDirectory(path)) {
                    Files.createDirectories(target);
                } else {
                    Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void deleteFolder(Path path) throws IOException {
        if (!Files.exists(path)) return;

        Files.walk(path)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(p -> {
                    try {
                        Files.deleteIfExists(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
