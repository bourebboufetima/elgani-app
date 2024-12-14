

# Project Overview - Elgani

This document provides an overview of the classes in the project and their respective functionalities.



## **Activity Classes**

1. **CahierListActivity**
   - Displays a list of cahier de charges.
   - Allows the user to browse and select a specification file.

2. **ChatActivity**
   - Facilitates real-time chat between customers and service providers.
   - Manages message input and displays the chat history using `AdapterChat`.

3. **ClientOffersActivity**
   - Displays offers sent by service providers.
   - Shows details like price, duration.

4. **CustomerActivity**
   - Main activity for customers.
     

5. **CustomerFormActivity**
   - Activity for creating a new cahier de charge.
   - Includes fields such as name, description.
   - Sends the form data to relevant service providers.

6. **LoginActivity**
   - Handles user login.
   - Includes validation for different roles (e.g., customers, service providers).

7. **MainActivity**
   - Entry point of the application.
   - Manages app initialization and navigation to other activities.

8. **OfferDetailsActivity**
   - Displays details of a specific offer from a service provider.
   - Includes price, duration.

9. **RegisterActivity**
   - Handles user registration.
   - Accepts user details such as name, phone, email, and password.

10. **RoleSelectionActivity**
    - Allows users to select their role in the app (customer or service provider).

11. **SubCategoryActivity**
    - Displays subcategories under a selected profession or service category.

---

## **Data Model Classes**

1. **DataModal**
   - Represents a general data structure with `email` and `password` fields.
   - Can be expanded for additional data as needed.

2. **DataModalCahierdecharge**
   - Represents the structure of a cahier de charge (project specification file).
   - Includes fields such as description,name.

3. **Message**
   - Represents a single chat message.
   - Includes fields like sender, recipient, message content, and timestamp.

4. **Provider**
   - Represents a service provider in the system.
  

5. **User**
   - General class representing users (both customers and service providers).
   - Contains fields such as `fullname`, `email`, `phone`, and `password`.

---

## **Other Classes**

1. **Content**
   - General class representing cahiers de charges.
   

2. **MessageFilter**
   - Filters chat messages to block sensitive or personal information.
   - Ensures communication security between users.


3. **RetrofitAPI**
   - Interface for handling network requests using Retrofit.
   - Manages API calls to send and receive data from the server.

---

## ** Summary**
The project is organized into:
- **Adapters**: Handle RecyclerView data and UI binding.
- **Activities**: Manage screens and user interactions.
- **Data Models**: Represent data structures used in the app.
- **Utilities**: Provide reusable logic like message filtering and API calls.

---

