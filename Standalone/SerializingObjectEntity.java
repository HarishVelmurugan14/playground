package Standalone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("CallToPrintStackTrace")
class SerializingObjectEntity {
    public static void main(String[] args) {
        EntityClass entity = new EntityClass("Harish", 4);

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(entity);
            objectOutputStream.close();

            String serializedObject = byteArrayOutputStream.toString(StandardCharsets.ISO_8859_1);
            System.out.println("Serialized Object: " + serializedObject);

            byte[] byteArray = serializedObject.getBytes(StandardCharsets.ISO_8859_1);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            EntityClass reconstructedEntity = (EntityClass) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("Reconstructed Object: " + reconstructedEntity);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class EntityClass implements Serializable {
    String name;
    int id;

    public EntityClass(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
