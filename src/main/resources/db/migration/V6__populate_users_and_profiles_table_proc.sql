delimiter $$

create procedure populateThreeUsersAndProfiles()

BEGIN
    INSERT INTO users (name, email, password)
    VALUES ('user1', 'user1@example.com', 'hashed_password');

    INSERT INTO profiles(id, phone_number, loyalty_points, bio)
    VALUES ((select id from users where email = 'user1@example.com'), '12312', 123 ,"bio");


    INSERT INTO users (name, email, password)
    VALUES ('user2', 'user2@example.com', 'hashed_password');

    INSERT INTO profiles(id, phone_number, loyalty_points, bio)
    VALUES ((select id from users where email = 'user2@example.com'), '12213', 123 ,"bio");



    INSERT INTO users (name, email, password)
    VALUES ('user3', 'user3@example.com', 'hashed_password');

    INSERT INTO profiles(id, phone_number, loyalty_points, bio)
    VALUES ((select id from users where email = 'user3@example.com'), '12213', 123 ,"bio");



END $$

delimiter ;