/** Libs */
import React, { FC, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useMutation, useQuery } from "@apollo/client";

/** TS Interfaces */
import { Todo } from "../common/types";

/** Components */
import TodosForm from "../components/TodosForm";
import TodosList from "../components/TodosList";

/** Redux Helpers */
import { RootState } from "../redux/store";
import {
  addTodo as addTodoRedux,
  deleteTodo as deleteTodoRedux,
  toggleTodoStatus as toggleTodoStatusRedux,
  setTodosRemote,
} from "../redux/slices/todosSlice";

/** GraphQL Queries */
import { ADD_TODO, DELETE_TODO_BY_PK, GET_ALL_TODO } from "../graphQL/queries";

const Home: FC<any> = () => {
  const dispatch = useDispatch();
  const todos = useSelector((state: RootState) => state.todos.data);
  const [insert_todo_one, { data: newTodo }] = useMutation(ADD_TODO);
  const [delete_todo_by_pk] = useMutation(DELETE_TODO_BY_PK);
  const { loading, error, data, refetch } = useQuery(GET_ALL_TODO);

  const addTodo = (todoName: string) => {
    const payload = {
      title: todoName,
      completed: false,
    };
    insert_todo_one({ variables: { ...payload } });
  };

  const deleteTodo = (e: React.MouseEvent, todo: Todo) => {
    e.stopPropagation();
    delete_todo_by_pk({ variables: { id: todo.id } });
    dispatch(deleteTodoRedux(todo));
  };

  const toggleTodoStatus = (todo: Todo) => {
    dispatch(toggleTodoStatusRedux(todo));
  };

  useEffect(() => {
    if (!loading) dispatch(setTodosRemote(data.todo));
    refetch();
  }, [loading]);

  useEffect(() => {
    newTodo && dispatch(addTodoRedux(newTodo?.insert_todo_one));
  }, [newTodo]);

  if (loading) return <p className="text-white cap">Loading . . .</p>;
  if (error)
    return <p className="text-white cap">Error Occurred : ${error.message}</p>;

  return (
    <div className="w-full max-h-screen">
      <div className="w-full h-full flex items-center justify-center flex-col p-5 gap-5">
        <h1 className="font-bold text-transparent text-7xl bg-clip-text bg-gradient-to-r from-[#fbd94a] via-[#89bd84] to-[#3785f1]">
          todos
        </h1>

        <TodosForm addTodo={addTodo} />
        <div className="w-full h-[79vh] overflow-y-scroll">
          <TodosList
            todos={todos}
            deleteTodo={deleteTodo}
            toggleTodoState={toggleTodoStatus}
          />
        </div>
      </div>
    </div>
  );
};

export default Home;
