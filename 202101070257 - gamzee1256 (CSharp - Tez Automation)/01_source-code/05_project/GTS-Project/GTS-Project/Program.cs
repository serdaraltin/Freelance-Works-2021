using System;
using System.Windows.Forms;

namespace GTS_Project
{
    static class Program
    {

        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form_Anasayfa());
        }
    }
}
