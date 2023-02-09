import { combineReducers, configureStore } from '@reduxjs/toolkit';
import {
persistStore,
persistReducer,
FLUSH,
REHYDRATE,
PAUSE,
PERSIST,
PURGE,
REGISTER
} from "redux-persist";
import storage from "redux-persist/lib/storage";

// Slices
import todosReducer from './slices/todosSlice';

const rootReducer = combineReducers({
    todos: todosReducer
})

const persistConfig = {
    key: "root",
    version: 1,
    storage,
};

const persistedReduer = persistReducer(persistConfig, rootReducer)

export const store = configureStore({
    reducer: persistedReduer,
    middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
      },
    }),
})

export let persistor = persistStore(store);
export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch