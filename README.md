# songer
- **Creating a new application with artifact songr with Web and Thymeleaf dependencies.**

- In this application there are six routes:
1. `/`: This is the home page at the root.
2. `/hello`: You will see the greeting page.
3. `/capitalize/{cap}`: This route to capitalize(UPPER CASE) any sentence you write after `/capitalize/`
- Ex: `/capitalize/`hello world ==> HELLO WORLD
4. `/dataForm`: This route will take you to a form to add new albums and another form to add new songs.
5. `/albums`: This will take you to a page to show you all albums you added.
6. `/allSongs`: This will take you to a page that has all songs you added.

> ***Note: When you add a new album or a new song, it will be added to the database(`SQL`) firstly, then when you visit any route, the application will call the data from the database and generate it to you.***
