import { render, screen } from '@testing-library/react';
import AppPokemon from './App-pokemon';

test('renders learn react link', () => {
  render(<AppPokemon />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});