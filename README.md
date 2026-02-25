# Smart Campus Operations Hub

Full-stack university project for IT3030 PAF 2026. The system manages campus facilities, bookings, incident tickets, notifications, and audit logs using a Spring Boot REST API + React frontend + PostgreSQL.

## Tech Stack

- **Backend**: Java 17, Spring Boot, Spring Data JPA, Spring Security, OAuth2, PostgreSQL, H2 (dev)
- **Frontend**: React + Vite, React Router
- **Database**: PostgreSQL (Docker), H2 (in-memory for quick dev)
- **DevOps**: Docker, Docker Compose, npm, Maven

## Folder Structure & Member Ownership

```text
PAF/
  backend/                               <- Spring Boot REST API
    src/main/java/com/smartcampus/
      resources/                         <- Member 1 (Facilities + Analytics)
        controller/
        service/
        repository/
        entity/
        dto/
      bookings/                          <- Member 2 (Bookings + Conflict + Auto-expire)
        controller/
        service/
        repository/
        entity/
        dto/
      tickets/                           <- Member 3 (Tickets + SLA + Comments + Images)
        controller/
        service/
        repository/
        entity/
        dto/
      notifications/                     <- Member 4 (Notifications)
        controller/
        service/
        repository/
        entity/
        dto/
      security/                          <- Member 4 (Auth + Roles + JWT/OAuth)
      common/                            <- Shared utilities (ApiResponse, GlobalExceptionHandler)
      config/                            <- Shared configuration (SecurityConfig, etc.)

  frontend/                              <- React client application
    src/
      pages/
        auth/                            <- Member 4 (Login + Auth flow)
        resources/                       <- Member 1 (Resource list, forms, availability)
        bookings/                        <- Member 2 (Booking UI, My bookings, approvals)
        tickets/                         <- Member 3 (Ticket list/detail, comments, SLA)
        admin/                           <- Member 1 + Member 4 (Analytics + Audit views)
      components/                        <- Shared UI components (Navbar, modals, badges...)
      context/
        AuthContext.jsx                  <- Member 4 (global auth state)
      routes/
        PrivateRoute.jsx                 <- Member 4 (protected routes)
        AdminRoute.jsx                   <- Member 4 (admin-only routes)
      services/
        api.js                           <- Shared Axios instance (all members use)

  docker-compose.yml                     <- Group (run backend + frontend + PostgreSQL)
  README.md                              <- Group documentation entry point
```

## Running the Project (Local Dev)

### Backend (without Docker)

```bash
cd backend
.\mvnw -DskipTests package
.\mvnw spring-boot:run
```

Backend will be available at `http://localhost:8080`.

### Frontend (without Docker)

```bash
cd frontend
npm install
npm run dev
```

Frontend will be available at `http://localhost:5173`.

## Running with Docker Compose

Prerequisites: Docker Desktop (or Docker Engine) installed and running.

From the root `PAF` folder:

```bash
docker compose up --build
```

This will start:

- `smartcampus-db`       → PostgreSQL on `localhost:5432`
- `smartcampus-backend`  → Spring Boot on `http://localhost:8080`
- `smartcampus-frontend` → Nginx serving React app on `http://localhost:3000`

Open `http://localhost:3000` in your browser to access the frontend.

> Note: At this stage the project contains only skeleton controllers, services, and pages. Each member will implement their assigned endpoints and UI screens inside the folders marked with their member number.

