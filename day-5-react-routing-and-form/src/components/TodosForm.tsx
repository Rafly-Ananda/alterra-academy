import { FC, useState } from "react";
import { TodosFormProps } from "../common/types";

const TodosForm: FC<TodosFormProps> = ({ addTask }) => {
  const [taskName, setTaskName] = useState<string>("");
  const onFormSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (taskName.trim().length < 1) {
      alert("Task name, cannot be empty");
      return;
    }
    addTask(taskName);
    setTaskName("");
  };
  return (
    <form
      className="w-full flex items-center justify-center"
      onSubmit={onFormSubmit}
    >
      <input
        className="shadow-sm w-3/6 shadow-slate-500 drop-shadow-lg py-2 px-5 rounded-l-2xl outline-none"
        type="text"
        placeholder="Add todo..."
        value={taskName}
        onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
          setTaskName(e.target.value)
        }
      />
      <span className="shadow-sm shadow-slate-500 drop-shadow-lg py-2 px-5 rounded-r-2xl bg-gradient-to-r from-[#fbd94a] via-[#89bd84] to-[#3785f1] hover:from-pink-500 hover:to-yellow-500 font-semibold text-gray-800 hover:h-[40px]">
        <button className="w-full">submit</button>
      </span>
    </form>
  );
};

export default TodosForm;
