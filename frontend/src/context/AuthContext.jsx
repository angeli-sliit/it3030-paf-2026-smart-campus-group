import React, { useState } from "react";
import api from "../services/api";
import { AuthContext } from "./AuthContext";

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [token, setToken] = useState(null);

  const login = async (username, password) => {
    const res = await api.post("/auth/login", { username, password });
    setToken(res.data);
    setUser({ username });
    api.defaults.headers.common["Authorization"] = `Bearer ${res.data}`;
  };

  const logout = () => {
    setUser(null);
    setToken(null);
    delete api.defaults.headers.common["Authorization"];
  };

  // Helper: check if user has a role
  const hasRole = (role) => {
    if (!user || !user.roles) return false;
    return user.roles.includes(role);
  };

  // Helper: check if user is authenticated
  const isAuthenticated = !!token;

  return (
    <AuthContext.Provider value={{ user, token, login, logout, hasRole, isAuthenticated }}>
      {children}
    </AuthContext.Provider>
  );
};

