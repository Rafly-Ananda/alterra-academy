import React from "react";
import Navbar from "./Navbar";
import { Outlet } from "react-router-dom";
const Layout = () => {
  return (
    <div className="flex w-screen h-screen">
      <div className="absolute z-50">
        <Navbar />
      </div>
      <div className="w-full flex items-center justify-center bg-slate-700">
        <Outlet />
      </div>
    </div>
  );
};

export default Layout;
