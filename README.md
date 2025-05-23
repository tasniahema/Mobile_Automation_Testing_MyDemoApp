# 📱 Mobile App Automation Testing using Appium

This project is an automated test script for a demo Android application using **Appium**, **TestNG**, and **Java**. It simulates the user journey from opening the app, selecting products, adding them to the cart, performing login, checkout, entering payment details, and placing the order.

## 🚀 Technologies Used

- Java
- Appium
- TestNG
- Android Emulator (Pixel 4a)
- AndroidDriver (UiAutomator2)
- XPath locators
- Maven (optional)

## 🧪 Features Tested

- Opening the app and verifying the product screen
- Adding products to cart
- Updating item quantity in cart
- Proceeding to checkout
- Performing login with test credentials
- Filling in shipping and payment information
- Placing the order successfully

## ⚙️ Setup Instructions

### Prerequisites:

- Java JDK installed
- Android Studio and Android Emulator (Pixel4a or similar)
- Appium Server (Desktop or CLI)
- Appium Java Client Library
- TestNG
- IDE (e.g., IntelliJ IDEA or Eclipse)
- Node.js (for Appium)
- Enable Developer Mode & USB Debugging on your device or start emulator

---

### 🛠 How to Clone & Run this Project

```bash
# Step 1: Clone this repository
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name

# Step 2: Open the project in your IDE

# Step 3: Start the Android Emulator (e.g., Pixel4a)

# Step 4: Start Appium Server
# Make sure the server is running on http://127.0.0.1:4723

# Step 5: Run the TestNG class
# You can run MobileAppTest.java from your IDE or via Maven if configured
