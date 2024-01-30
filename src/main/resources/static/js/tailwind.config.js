/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./*.{html,js}", "./!(build|dist|.*)/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        "default-gray-50": "#f9fafb",
        gray: {
          "100": "rgba(255, 255, 255, 0.6)",
          "200": "rgba(255, 255, 255, 0.15)",
          "300": "rgba(255, 255, 255, 0.5)",
        },
        "white-white": "#fff",
        "dark-main-black": "#000",
        "blue-blue-light": "#e0e5f7",
        "blue-main": "#2b53e2",
        mediumslateblue: "#2851e3",
      },
      fontFamily: {
        "caption-caption": "'Montserrat Alternates'",
        "kaushan-script": "'Kaushan Script'",
      },
      borderRadius: {
        "6xl": "25px",
        "31xl": "50px",
        "10xs": "3px",
      },
    },
    fontSize: {
      xs: "12px",
      base: "16px",
      "9xl": "28px",
      "xl-9": "20.9px",
      "19xl": "38px",
    },
  },
  corePlugins: {
    preflight: false,
  },
};
