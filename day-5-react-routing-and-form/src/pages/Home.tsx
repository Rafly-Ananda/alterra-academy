import React, { FC } from "react";
import TodosForm from "../components/TodosForm";
import TodosList from "../components/TodosList";
import { Task, HomeProps } from "../common/types";

const Home: FC<HomeProps> = ({ taskList, setTaskList }) => {
  const addTask = (taskName: string) => {
    setTaskList((tasks: Task[]) => [
      ...tasks,
      {
        id: taskList.length,
        title: taskName,
        completed: false,
      },
    ]);
  };

  const deleteTask = (e: React.MouseEvent, task: Task) => {
    e.stopPropagation();
    setTaskList((tasks: Task[]) => tasks.filter((e: Task) => e.id !== task.id));
  };

  const toggleTaskState = (task: Task) => {
    setTaskList((tasks: Task[]) =>
      [
        ...tasks.filter((e: Task) => e.id !== task.id),
        {
          ...task,
          completed: !task.completed,
        },
      ].sort((a, b) => a.id - b.id)
    );
  };

  return (
    <div className="w-full max-h-screen">
      <div className="w-full h-full flex items-center justify-center flex-col p-5 gap-5">
        <h1 className="font-bold text-transparent text-7xl bg-clip-text bg-gradient-to-r from-[#fbd94a] via-[#89bd84] to-[#3785f1]">
          todos
        </h1>

        <TodosForm addTask={addTask} />
        <div className="w-full h-[79vh] overflow-y-scroll">
          <TodosList
            tasks={taskList}
            deleteTask={deleteTask}
            toggleTaskState={toggleTaskState}
          />
        </div>
      </div>
    </div>
  );
};

export default Home;
