export interface Task {
    id: number
    title: string
    completed: boolean
}

export interface TodosFormProps {
    addTask: (task: string) => void;
}

export interface TodosListProps {
    tasks: Task[]
    deleteTask: (e:React.MouseEvent, task: Task) => void;
    toggleTaskState: (task: Task) => void;
}