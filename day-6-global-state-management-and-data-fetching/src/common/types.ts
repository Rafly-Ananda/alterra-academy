export interface Todo {
    id: number
    title: string
    completed: boolean
}

export interface TodosFormProps {
    addTodo: (todoName: string) => void;
}

export interface TodosListProps {
    todos: Todo[]
    deleteTodo: (e:React.MouseEvent, todo: Todo) => void;
    toggleTodoState: (todo: Todo) => void;
}

export interface HomeProps {
    todoList: Todo[]
    setTodoList: React.Dispatch<React.SetStateAction<Todo[]>>
}

// export interface todosGQLQuery {
//     id: string,
//     title: string,
//     completed: string
// }