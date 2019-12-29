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
            foreach(USER user in lstUser)
            {
                user.ID = null;
            }
            return lstUser;
        }


        [HttpGet]
        public USER GetUser(string usn, string pass)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            USER User = context.USERs.FirstOrDefault(x => x.NUMPHONE == usn && x.PASS == pass);
            if (User != null)
            {
                return new USER
                {
                    ID = User.ID,
                    ADDRESS = User.ADDRESS,
                    NAME = User.NAME,
                    NUMPHONE = User.NUMPHONE,
                    PASS = User.PASS,
                    USN = User.USN
                };
            }
            return User;
        }
    }
}
