import {ComponentPreview, Previews} from '@react-buddy/ide-toolbox'
import {PaletteTree} from './palette'
import MovieApp2 from "../MovieApp2";

const ComponentPreviews = () => {
  return (
    <Previews palette = {<PaletteTree />}>
      <ComponentPreview path = "/MovieApp2">
        <MovieApp2 />
      </ComponentPreview>
    </Previews>
  )
}

export default ComponentPreviews