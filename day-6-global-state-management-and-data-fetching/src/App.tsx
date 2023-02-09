/** Libs */
import { FC } from "react";
import { Routes, Route } from "react-router-dom";

/** Components */
import Home from "./pages/Home";
import About from "./pages/About";
import Layout from "./components/Layout";
import NotFound from "./pages/NotFound";
import Form from "./pages/Form";

const App: FC<any> = () => {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Home />} />
        <Route path="about" element={<About />} />
        <Route path="form" element={<Form />} />
        <Route path="*" element={<NotFound />} />
      </Route>
    </Routes>
  );
};

export default App;
