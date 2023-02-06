import React, { useState } from "react";
import { Link } from "react-router-dom";
import Hamburger from "hamburger-react";

const links = [
  { title: "HOME", path: "/" },
  { title: "ABOUT", path: "/about" },
  { title: "FORM ASSIGNMENT", path: "/form" },
];

const Navbar = () => {
  const [navbarState, setNavbarState] = useState<boolean>(false);
  return (
    <div>
      <Hamburger
        toggled={navbarState}
        toggle={setNavbarState}
        color="#ffffff"
      />
      <div
        className={`top-0 left-0 w-fit bg-slate-800 text-white fixed h-full ease-in-out duration-300 ${
          navbarState ? "translate-x-0 " : "-translate-x-full"
        } flex flex-col items-center`}
      >
        <div className="w-full flex justify-end">
          <Hamburger toggled={navbarState} toggle={setNavbarState} />
        </div>

        <ul className="flex flex-col items-center justify-center gap-5 font-semibold px-10 mt-5">
          {links.map((link, i) => (
            <li key={i} onClick={() => setNavbarState(false)}>
              <Link to={link.path} replace>
                {link.title}
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default Navbar;
