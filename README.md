# 🎟️ BookMyShow App Clone

A fully functional clone of the popular movie ticket booking app, **BookMyShow**. This project replicates the core features of BookMyShow, allowing users to log-in, sign-up, browse movies, check showtimes, book tickets, and manage bookings.
This is a command line runner application, where a connection to the local database is to be established.

## 🚀 Features

- **User Authentication**: Sign up, log in, and manage profiles, storing the passwords in encrypted format using BcryptPasswordEncoder method in Springboot.
- **Browse Movies**: Explore a list of currently playing and upcoming movies.
- **Theater Listings**: View a list of theaters showing a selected movie.
- **Seat Selection**: Choose your favorite seats before booking, where the concurrency is handled by serializable method.
- **Booking Management**: View and manage past and upcoming bookings.

## 🛠️ Technologies Used

### Backend
- **Java**: Programming language.
- **Spring Boot**: For building the backend RESTful API.
- **Spring Security**: For user authentication and authorization.
- **Hibernate & JPA**: For database interactions.
- **MySQL**: For storing user, movie, and booking data.
- **Maven**: For dependency management and build automation.

## Services
#### 1. Booking Service
  -  We fetch the user details, show details from the respective repositories, and handle the exceptions here itself, and then move on to the payment page.
#### 2. PriceCalculator Service
  - Price is calculated as per the showSeatType for every seat, showSeatType includes all the details of the show venue and timings, screen etc.
#### 3. UserService
  - Here we implement the user login and signup feature, and all the details of the user is saved in the database. Where, the password is saved in the encrypted format using BcryptPasswordEncoder.
