# 🧠 NeuroPath

### 🔬 Personalized Career Insight & Upskilling Recommendation System

---

## 🚀 Problem Statement

In today’s rapidly evolving job market, professionals struggle to identify the right skills, certifications, or career transitions to stay competitive. Generic career guidance platforms like LinkedIn fail to provide **personalized and data-driven insights** based on an individual’s true potential. With the growing number of courses, certifications, and roles, it's easy to feel overwhelmed and directionless.

---

## 💡 Solution

**NeuroPath** is an intelligent Spring Boot-based platform that analyzes a user's **resume or manually entered profile** to extract skills, interests, education, and experience, and provides **custom career growth suggestions**. It integrates smart parsing, recommendation logic, and email-based communication to ensure the user gets the most relevant and tailored advice. This project is aimed at freshers, professionals, and career switchers to bridge the gap between potential and opportunities.

---

## 🧰 Technologies Used

- 💻 Java 17
- 🌱 Spring Boot
- 📫 Spring Mail
- 🗄️ PostgreSQL
- 📑 Apache Tika (Resume Parsing)
- 🔐 Spring Security & JWT (For Auth)
- 🧪 Postman (For API Testing)
- ☁️ Maven (Dependency Management)

---

## 🌟 Features

### 📄 1. Resume Upload & Auto-Parsing
NeuroPath allows users to upload their resumes in PDF or DOCX format.  
It intelligently extracts key data like **Name, Email, Location, Skills, Education**, and **Projects**.  
This process is powered by **Apache Tika**, ensuring support for various file formats.  
Users don’t need to manually fill lengthy forms — just upload and go!  
It even sends a welcome email to the parsed email address automatically.  

---

### ✍️ 2. Manual Profile Creation
Users can also create their profile manually by entering key fields like name, email, education, and skills.  
This is useful for those who want fine-grained control over their profile.  
The system validates the input and ensures only proper data is accepted.  
Manual entry is stored securely in the PostgreSQL database.  
This also supports future updates or edits to your data.  

---

### 🔐 3. Secure Login and Signup (JWT-Based)
Authentication is handled using **Spring Security with JWT** tokens.  
After signup, users can log in and receive a JWT to access protected APIs.  
Only authenticated users can view or edit their profiles or feedback.  
This ensures data privacy and protects sensitive user information.  
Tokens are included in the request headers using Postman or frontend apps.  

---

### 📬 4. Automated Email Notifications
Whenever a resume is uploaded, NeuroPath sends an email to the extracted email address.  
This email can contain a welcome message or verification information.  
It ensures that the user is notified instantly about their account status.  
Built using Spring Mail and configured with Gmail SMTP.  
You can also customize email templates for branding and alerts.  

---

### 📊 5. Feedback System
Users can leave feedback or comments related to their experience or suggestions.  
Feedback is linked to the user via their ID and stored in the database.  
Admins or developers can review this feedback for improvements.  
Useful for understanding user pain-points and enhancing usability.  
All feedback operations (POST/GET/DELETE) are secured using JWT.  

---

### 🔍 6. Role Prediction Based on Skills
Once a resume is parsed or profile is created, the system can recommend roles.  
For example, someone with Python, Pandas, and ML may be shown **"Data Scientist"**.  
This mapping uses simple keyword-to-role logic which can be enhanced with AI later.  
It helps users get a sense of where their strengths can lead them.  
Recommendations are stored along with the user profile for future use.  

---

## 👨‍💻 Developed By

**👤 Sauvir Wodehra**  
- 🔗 [GitHub](https://github.com/SauvirWodehra)  
- 💼 [LinkedIn](https://www.linkedin.com/in/sauvir-wodehra-032821257)  
- 📧 sauvirwodehras3136@gmail.com  


---

## 🧪 How to Run

1. Clone the repo: `git clone https://github.com/SauvirWodehra/NeuroPath.git`
2. Set up PostgreSQL and update credentials in `application.properties`
3. Run using `mvn spring-boot:run` or from your IDE
4. Test endpoints using Postman (Signup, Login, Upload Resume, etc.)
5. Verify emails are received and data is stored

---

## 🏁 Future Improvements

- Integrate OpenAI API to suggest better career paths  
- Resume scoring system based on industry keywords  
- Chatbot for career Q&A  
- Analytics dashboard for user skill trends  
- Admin dashboard for feedback management

