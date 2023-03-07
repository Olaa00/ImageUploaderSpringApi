SELECT * FROM appimage.user;
USE appimage;
INSERT INTO user (password, role, username) VALUES ('qwertypass' , 'USER', 'Tomek');
DELETE FROM user WHERE id= 3;
DELETE FROM user WHERE id= 4;
DELETE FROM user WHERE id= 8;