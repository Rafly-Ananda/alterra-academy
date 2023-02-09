import { gql, useMutation, useQuery } from "@apollo/client";

export const GET_ALL_TODO = gql`
  query {
    todo {
      id
      title
      completed
    }
  }
`;

export const ADD_TODO = gql`
  mutation AddTodo($completed: Boolean = false, $title: String = "") {
    insert_todo_one(object: { title: $title, completed: $completed }) {
      completed
      id
      title
    }
  }
`;

export const DELETE_TODO_BY_PK = gql`
  mutation DeleteTodo($id: Int!) {
    delete_todo_by_pk(id: $id) {
      id
    }
  }
`;