// Container.js
import React from 'react';
import Button from "./Button";

function Container({ text, setColor, style }) {
  const onClick = () => {
    setColor(text);
  };
  return (
    <div className="container" style={style}>
      <h3>{text}</h3>
      <Button onClick={onClick}>button</Button>
    </div>
  );
}

export default Container;