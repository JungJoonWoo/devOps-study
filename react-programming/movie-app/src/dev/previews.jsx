import {ComponentPreview, Previews} from '@react-buddy/ide-toolbox'
import {PaletteTree} from './palette'
import MovieApp2 from "../MovieApp2";
import Home from "../routes/Home";

const ComponentPreviews = () => {
  return (
    <Previews palette = {<PaletteTree />}>
      <ComponentPreview path = "/MovieApp2">
        <MovieApp2 />
      </ComponentPreview>
      <ComponentPreview path = "/MovieApp3">
        <Home />
      </ComponentPreview>
    </Previews>
  )
}

export default ComponentPreviews