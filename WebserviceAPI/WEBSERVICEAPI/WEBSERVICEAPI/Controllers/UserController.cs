using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WEBSERVICEAPI.Controllers
{
    public class UserController : ApiController
    {
        [HttpGet]
        public List<USER> GetAllUser()
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            List<USER> lstUser = context.USERs.ToList();
            return lstUser;
        }

        [HttpGet]
        public USER GetUser(string usn, string pass)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            USER User = context.USERs.FirstOrDefault(x => x.USN == usn && x.PASS == pass);
            return User;
        }
    }
}
