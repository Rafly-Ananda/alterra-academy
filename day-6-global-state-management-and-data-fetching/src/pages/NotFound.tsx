/** Libs */
import { useNavigate } from "react-router-dom";

const NotFound = () => {
  const navigate = useNavigate();
  const navigateBack = () => {
    navigate("/", { replace: true });
  };

  return (
    <div className="w-full h-full flex flex-col items-center justify-center gap-5">
      <h1 className="font-bold text-transparent text-7xl bg-clip-text bg-gradient-to-r from-[#fbd94a] via-[#89bd84] to-[#3785f1]">
        Page Not Found.
      </h1>

      <button
        onClick={navigateBack}
        className="w-fit bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
      >
        return to home
      </button>
    </div>
  );
};

export default NotFound;
