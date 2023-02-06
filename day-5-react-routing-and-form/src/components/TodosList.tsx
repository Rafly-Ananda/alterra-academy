import { FC } from "react";
import { TodosListProps } from "../common/types";

const TodosList: FC<TodosListProps> = ({
  tasks,
  deleteTask,
  toggleTaskState,
}) => {
  return (
    <ul className="w-full flex flex-col items-center justify-center">
      {tasks.map((task) => (
        <li
          key={task.id}
          className="w-3/5 flex items-center justify-between p-2 border-b border-gray-400 hover:bg-gradient-to-r from-[#fbd94a] via-[#89bd84] to-[#3785f1] hover:rounded-lg text-neutral-50 hover:text-slate-700"
          onClick={() => toggleTaskState(task)}
        >
          <div>
            <input
              type="checkbox"
              name="isComplete"
              id="isComplete"
              checked={task.completed}
              onChange={() => toggleTaskState(task)}
            />
            <span
              className={`ml-4 text-lg  ${
                task.completed && "italic line-through text-slate-400"
              }`}
            >
              {task.title}
            </span>
          </div>

          <button
            className="bg-slate-200 p-1 rounded-full h-12 w-12 text-xs font-semibold text-slate-700"
            onClick={(e: React.MouseEvent) => deleteTask(e, task)}
          >
            Delete
          </button>
        </li>
      ))}
    </ul>
  );
};

export default TodosList;
