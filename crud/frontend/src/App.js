import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import Home from "./components/views/Home";
import ClientList from "./components/client/ClientList";

const App = () => {
  return (
    <Router>
      <Switch>
        <Route path="/" exact={true} component={Home} />
        <Route path="/clients" exact={true} component={ClientList} />
        {/* <Route path="/clients/:id" component={ClientEdit} /> */}
      </Switch>
    </Router>
  );
};

export default App;
