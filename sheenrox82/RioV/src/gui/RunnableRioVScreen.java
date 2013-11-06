package sheenrox82.RioV.src.gui;

import java.io.IOException;

import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
class RunnableRioVScreen extends Thread
{
    final GuiRioVMainMenu theMainMenu;

    RunnableRioVScreen(GuiRioVMainMenu par1GuiDonaldsMenu)
    {
        this.theMainMenu = par1GuiDonaldsMenu;
    }

    public void run()
    {
        McoClient mcoclient = new McoClient(GuiRioVMainMenu.func_110348_a(this.theMainMenu).getSession());
        boolean flag = false;

        for (int i = 0; i < 3; ++i)
        {
            try
            {
                Boolean obool = mcoclient.func_96375_b();

                if (obool.booleanValue())
                {
                	GuiRioVMainMenu.func_130021_b(this.theMainMenu);
                }

                GuiRioVMainMenu.func_110349_a(obool.booleanValue());
            }
            catch (ExceptionRetryCall exceptionretrycall)
            {
                flag = true;
            }
            catch (ExceptionMcoService exceptionmcoservice)
            {
            	GuiRioVMainMenu.func_130018_c(this.theMainMenu).getLogAgent().logSevere(exceptionmcoservice.toString());
            }
            catch (IOException ioexception)
            {
            	GuiRioVMainMenu.func_130019_d(this.theMainMenu).getLogAgent().logWarning("Realms: could not parse response");
            }

            if (!flag)
            {
                break;
            }

            try
            {
                Thread.sleep(10000L);
            }
            catch (InterruptedException interruptedexception)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}