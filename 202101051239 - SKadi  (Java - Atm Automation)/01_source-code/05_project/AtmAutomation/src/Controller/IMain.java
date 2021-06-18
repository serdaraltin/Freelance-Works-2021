package Controller;

import Model.MMain;

public interface IMain extends ISub<MMain>{

    public boolean Control(int Id);

    public boolean Delete(int Id);

    public void Update(int Id);

    public void Open();

}
