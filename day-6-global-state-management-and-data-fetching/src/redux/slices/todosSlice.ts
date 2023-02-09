import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { Todo } from "../../common/types";

interface TodosState {
    data: Todo[]
} 

const initialState: TodosState  = {
    data: []
}

export const todosSlice = createSlice({
    name: "todos",
    initialState,
    reducers : {
        addTodo: (state, action:PayloadAction<Todo>) => {
            state.data?.push(action.payload)
        },
        deleteTodo: (state, action:PayloadAction<Todo>) => {
            state.data = state.data?.filter((todo) => todo.id !== action.payload.id)
        },
        toggleTodoStatus: (state, action:PayloadAction<Todo>) => {
            state.data = state.data.map((todo) => {
                if (todo.id === action.payload.id) {
                    todo.completed = !todo.completed
                }
                return todo
            })
        },
        setTodosRemote: (state, action:PayloadAction<Todo[]>) => {
            state.data = [...action.payload]
        }
    }

})

export const {addTodo, deleteTodo, toggleTodoStatus, setTodosRemote} = todosSlice.actions;
export default todosSlice.reducer;

