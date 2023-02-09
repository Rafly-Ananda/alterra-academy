import { useForm } from "react-hook-form";

const educationList = ["IT", "Non IT"];
const codingCLass = ["Python", "Javascript", "Java", "Golang", "C++"];

const Form = () => {
  const {
    register,
    handleSubmit,
    formState: { errors, touchedFields, defaultValues },
    reset,
  } = useForm({
    defaultValues: {
      name: "",
      email: "",
      phone: "",
      education: "",
      codingClass: "default",
      earnestnessLetter: null,
      suggestion: "",
    },
  });

  const onSubmitHandler = (val: any) => {
    if (Object.keys(errors).length > 1) {
      alert("Form data is invalid, please correct them");
      return;
    } else {
      alert(`Data Pendaftaran ${val.name} Berhasl Diterima`);
    }
  };

  const onFormReset = () => {
    reset(defaultValues);
  };

  return (
    <form
      className="flex flex-col gap-2 w-4/5 lg:w-4/12"
      onSubmit={handleSubmit(onSubmitHandler)}
    >
      <div className="flex flex-col gap-1">
        <label htmlFor="name" className="text-white">
          Nama Lengkap:
        </label>
        <input
          {...register("name", {
            required: { value: true, message: "Cannot be empty" },
            pattern: {
              value: /^[A-z]+$/,
              message: "Symbol or Number is not allowed",
            },
          })}
          type="name"
          id="name"
          className="py-1 px-2 rounded-full"
        />
        <span className="text-red-500">
          {touchedFields?.name &&
            errors?.name &&
            ` ** ${errors?.name?.message}`}
        </span>
      </div>
      <div className="flex flex-col gap-1">
        <label htmlFor="email" className="text-white">
          Email:
        </label>
        <input
          {...register("email", {
            required: { value: true, message: "Cannot be empty" },
          })}
          type="email"
          id="email"
          className="py-1 px-2 rounded-full"
        />
        <span className="text-red-500">
          {touchedFields?.email &&
            errors?.email &&
            ` ** ${errors?.email?.message}`}
        </span>
      </div>
      <div className="flex flex-col gap-1">
        <label htmlFor="phone" className="text-white">
          No Handphone:
        </label>
        <input
          {...register("phone", {
            required: { value: true, message: "Cannot be empty" },
            pattern: {
              value: /^[0-9]*$/,
              message: "Only combination of number 1 - 9",
            },
          })}
          type="tel"
          id="phone"
          className="py-1 px-2 rounded-full"
        />
        <span className="text-red-500">
          {touchedFields?.phone &&
            errors?.phone &&
            ` ** ${errors?.phone?.message}`}
        </span>
      </div>

      <div className="flex flex-col">
        <label className="text-white">Latar Belakang Pendidikan:</label>
        <div className="flex gap-2 text-white">
          {educationList.map((e) => (
            <div key={e} className="flex gap-2">
              <input
                {...register("education", {
                  required: { value: true, message: "Cannot be empty" },
                })}
                type="radio"
                value={e}
                id="education"
                className="p-2"
                name="education"
              />
              <label htmlFor="education">{e}</label>
            </div>
          ))}
        </div>
      </div>

      <div className="flex flex-col gap-2">
        <label htmlFor="codingClass" className="text-white">
          Kelas coding yang dipilih:
        </label>
        <select
          {...register("codingClass", {
            required: { value: true, message: "Cannot be empty" },
          })}
          name="codingClass"
          id="codingClass"
          defaultValue="default"
          className="py-1 px-2 rounded-full"
        >
          {codingCLass.map((e) => (
            <option value={e} key={e}>
              {e}
            </option>
          ))}
          <option value="default" hidden>
            Pilih salah satu program
          </option>
        </select>
      </div>

      <div className="flex flex-col gap-2 text-white">
        <label htmlFor="earnestnessLetter">Foto Surat Kesungguhan</label>
        <input
          {...register("earnestnessLetter", {
            required: { value: true, message: "Cannot be empty" },
          })}
          type="file"
          id="earnestnessLetter"
          name="earnestnessLetter"
        />
      </div>

      <div className="flex flex-col gap-2">
        <label htmlFor="suggestionsInput" className="text-white">
          Foto Surat Kesungguhan:
        </label>
        <textarea
          {...register("suggestion", {
            required: { value: true, message: "Cannot be empty" },
          })}
          className="p-1 rounded-md"
        />
      </div>

      <div className="flex gap-5 mt-10">
        <button
          type="submit"
          className="w-24 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          submit
        </button>
        <button
          type="button"
          onClick={onFormReset}
          //   disabled={isDirty ? false : true}
          className="w-24 bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
        >
          reset
        </button>
      </div>
    </form>
  );
};

export default Form;
