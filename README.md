# 🎟️ BookMyShow App Clone, APIs Spring Boot Project

A fully functional clone of the popular movie ticket booking app, **BookMyShow**. This project replicates the core features of BookMyShow, allowing to add movie shows in theatre, user sign-up, check showtimes, book tickets, and the tickets are automatically sent to the user's email address.
To test the Application, we need to make API calls using Postman.

## 🚀 Features

- **User SignUp**: Sign up with user details, and  storing the details in database, it is a prerequisite to book the tickets.
- **Add Movies**: Add the latest movies to be played on the alloted screeen.
- **Show Listing**: Add shows of movies on particular date and time, for which the tickets can be booked. Users can browse through the list of shows available for a movie.
- **Seat Selection**: Choose your favorite three tier seats before booking, where the concurrency is handled by serializable method.
- **Tickets on Mail**: Tickets are being automatically sent to the users email with all the necessary details.

## 🛠️ Technologies Used

### ⚙️Backend
- **Java**: Programming language.
- **Spring Boot**: For building the backend RESTful API.
- **Spring Security**: For user authentication and authorization.
- **Hibernate & JPA**: For database interactions.
- **MySQL**: For storing user, movie, and booking data.
- **Maven**: For dependency management and build automation.
- **SMTP Server**: For sending email notifications with the ticket details.

## ✅Getting Started
 To set up the project on your local machine, follow these steps:
 - 1. Clone the repository:    ```https://github.com/kaushalmarandi/BookMyShow_2024```
   2. Navigate to the directory: ```cd BookMyShow_2024```
   3. Configure the database settings in ```application.properties``` file.
   4. Build the project using Maven: ```mvn clean install```
   5. Run the application: ```mvn spring-boot:run```
   6. To properly see the json output for ticket booking, install the following dependency on ```pom.xml``` when using maven.
      ```xml
       <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>
   8. Use Postman to access the application via API on: ```https://localhost:8080/```

## ⚓️Database setup
This project uses MySQL as the database. Follow these steps to set up the database
- 1. Install MySQL on your local machine.
  2. Create a new database named bookmyshow.
  3. Update the database configuration in ```application.properties``` file.

## 🍃Flow
### 1.  Add Movie Service
  - Add movie to the theatre by making a post api call on
      
        localhost:8080/movie/addNew
 - Enter the movie details in the following format
   ```json
   {
      "movieName" : "Dune",
      "genre" : "FICTION",
      "language" : "ENGLISH"
   }

### 2. Add a screen to the theatre, by making an api call to
     ` 
     localhost:8080/screen/addNew
   - Add the screen details in the following format
     ```json
     {
        "name" : "Audi-1",
        "screenType" : "TWO_D"
     }
  - To add the seat details in a particular screen, post api call on
 
        localhost:8080/screen/addScreenSeat

   - add sceen seat details in the format
     ```json
     {
           "screenName" : "Audi-1",
           "noOfSeatInRow" : 10,
           "noOfSilverSeats" : 30,
           "noOfGoldSeats" : 20,
           "noOfPlatinumSeats" : 10
     }

### 3. Add show details for the movie, by
 - making a api call to
   
           localhost:8080/show/addNew
- Enter the show details in the format
  ```json
  {
       "showStartTime" : "14:30:00",
       "showDate" : "2024-11-08",
       "screenId" : 1,
       "movieId" : 1
  }

- Associate show seat price with the screen seats in the endpoint

      localhost:8080/show/associateSeats
- in the format
  ```json
  {
      "showId" : 1,
      "priceOfSilverSeat" : 150,
      "priceOfGoldSeat" : 200,
      "priceOfPlatinumSeat" : 250
   }


### 4. User SignUp Service.
  - User needs to signUp before the tickets can be booked for any user.
  - API call need to be made on
  - 

        localhost:8080/user/addNew

  - The input needs to be in the following format.
     ```json  {
     {
        "name" : "Kaushal"
        "email" : "iamkash009@gmail.com"
        "password" : "k@123"
     }
### 5. Ticket Booking Service.
- Email where the ticket is to be receieved should be entered, along with show and seat details.
  - Ticket can be booked for a show by making a call on

        localhost:8080/ticket/book

 -  details to be entered as
   ```json
   {
        "showId" : 1,
        "userEmail" : "iamkash009@gmail.com",
        "seatType"  : "GOLD",
        "requestSeats" : ["A1", "A2"]
   }
```
### 6. Other Services
- **Get show timings of a movie on a particular date**
- - make a get call on the api

        localhost:8080/show/showTimingsOnDate
    - with the input as
      ```json
      {
          "date" : "2024-11-08",
          "movieId" : 1
      }
- **Get all shows of a movie**
- - make a get api call on

        localhost:8080/show/allShowsOfMovie
  - with the input as
    ```json
    {
        "movieId" : 1
    }

  


