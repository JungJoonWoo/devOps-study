import PropTypes from "prop-types";

function Button({text, onClick}) {
  return (
    <button
      onClick={onClick}
      style = {
      {backgroundColor: "indigo", color: "white"}}>
      {text}
    </button>
  )
}

Button.propTypes = {
  text: PropTypes.string.isRequired,

}
export default Button;