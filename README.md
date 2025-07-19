# 📬 Reply Flow AI

**Reply Flow AI** is an AI-powered email reply generator using Spring Boot (Java) for backend, React with Vite for frontend, and Gemini AI API for AI integration.

To get started, clone the repo:  
`git clone https://github.com/Laxminarayana-Bhat/email-generator.git`  
`cd reply-flow-ai`

Install and run the backend (email-writer-backend):  
`cd email-writer-backend`  
`mvn clean install`  
`mvn spring-boot:run`  
Backend will be available at `http://localhost:8080`

Install and run the frontend (email-writer-ui):  
`cd ../email-writer-ui`  
`npm install`  
`npm run dev`  
Frontend will be available at `http://localhost:5173`

Make sure to set environment variables:  
For backend (`application.properties`):  
`GEMINI_KEY=your_gemini_api_key`  
