/** Libs */
import { useState, useEffect, FC } from "react";
import { Routes, Route } from "react-router-dom";

/** Types */
import { Task } from "./common/types";

/** Components */
import Home from "./pages/Home";
import About from "./pages/About";
import Layout from "./components/Layout";
import NotFound from "./pages/NotFound";
import Form from "./pages/Form";

const App: FC<any> = () => {
  const [taskList, setTaskList] = useState<Task[]>([]);

  return (
    <Routes>
      <Route element={<Layout />}>
        <Route
          path="/"
          element={<Home taskList={taskList} setTaskList={setTaskList} />}
        />
        <Route path="about" element={<About />} />
        <Route path="form" element={<Form />} />
        <Route path="*" element={<NotFound />} />
      </Route>
    </Routes>
  );
};

export default App;
