using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Crypto_Program_MVC.Startup))]
namespace Crypto_Program_MVC
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
