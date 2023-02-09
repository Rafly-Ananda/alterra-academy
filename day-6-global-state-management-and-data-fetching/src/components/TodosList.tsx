import { FC } from "react";
import { TodosListProps } from "../common/types";

const TodosList: FC<TodosListProps> = ({
  todos,
  deleteTodo,
  toggleTodoState,
}) => {
  return (
    <ul className="w-full flex flex-col items-center justify-center hover:cursor-pointer">
      {todos.map((todo) => (
        <li
          key={todo.id}
          className="w-3/5 flex items-center justify-between p-2 border-b border-gray-400 hover:bg-gradient-to-r from-[#fbd94a] via-[#89bd84] to-[#3785f1] hover:rounded-lg text-neutral-50 hover:text-slate-700"
          onClick={() => toggleTodoState(todo)}
        >
          <div>
            <input
              type="checkbox"
              name="isComplete"
              id="isComplete"
              checked={todo.completed}
              onChange={() => toggleTodoState(todo)}
            />
            <span
              className={`ml-4 text-lg  ${
                todo.completed && "italic line-through text-slate-400"
              }`}
            >
              {todo.title}
            </span>
          </div>

          <button
            className="bg-slate-200 p-1 rounded-full h-12 w-12 text-xs font-semibold text-slate-700"
            onClick={(e: React.MouseEvent) => deleteTodo(e, todo)}
          >
            Delete
          </button>
        </li>
      ))}
    </ul>
  );
};

export default TodosList;
