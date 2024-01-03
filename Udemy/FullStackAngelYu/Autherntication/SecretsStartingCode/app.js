import "dotenv/config";
import express from "express";
import bodyParser from "body-parser";
import mongoose from "mongoose";
import encrypt from "mongoose-encryption";

const app = express();
const port = 3000;

app.use(express.static("public"));
app.use(bodyParser.urlencoded({ extended: true }));
mongoose
  .connect("mongodb://127.0.0.1:27017/development")
  .then(() => console.log("Connected!"));

const userSchema = new mongoose.Schema({
  email: { type: String },
  password: { type: Number },
});
userSchema.plugin(encrypt, { secret: process.env.SECRET, encryptedFields: ["password"]});
const User = mongoose.model("User", userSchema);

app.get("/", (req, res) => {
  res.render("home.ejs");
});
app.get("/register", (req, res) => {
  res.render("register.ejs");
});

app.post("/register", async (req, res) => {
  const newUser = new User({
    email: req.body.username,
    password: req.body.password,
  });
  newUser
    .save()
    .then((savedUser) => {
      console.log("User saved successfully:", savedUser);
      res.render("secrets.ejs");
    })
    .catch((error) => {
      console.error("Error saving user:", error);
      res.send("ERROR");
    });
});

app.get("/login", (req, res) => {
  res.render("login.ejs");
});

app.post("/login", (req, res) => {
  const username = req.body.username;
  const password = parseInt(req.body.password);

  User.findOne({ email: username })
    .then((foundUser) => {
      //console.log("Found user", foundUser);
      console.log("Match found");
      if (foundUser.password === password) {
        res.render("secrets.ejs");
      }else{
        console.log("No match");
      }
    })
    .catch((error) => {
      console.error("Error finding user:", error);
      res.send("ERROR");
    });
});

app.listen(port, () => {
  console.log(`Server running on port: ${port}`);
});
