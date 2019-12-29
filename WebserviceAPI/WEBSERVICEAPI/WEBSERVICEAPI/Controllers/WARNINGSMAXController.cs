using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WEBSERVICEAPI.Controllers
{
    public class WARNINGSMAXController : ApiController
    {
        [HttpGet]
        public List<WARNINGSMAX> GetAllWarnings(string IDUSER)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();

            USER_DEVICEController ds = new USER_DEVICEController();

            List<DEVICE> lstDevice = ds.DanhSachThietBiCuaNguoiDung(IDUSER);
            List<WARNINGSMAX> lstWarnings = new List<WARNINGSMAX>();
            foreach (DEVICE item in lstDevice)
            {
                SENSORController ss = new SENSORController();
                List<SENSOR> lstSS = ss.DanhSachCamBienCuaThietBi(item.ID);
                foreach (SENSOR sens in lstSS)
                {
                    WARNINGSMAX dv = context.WARNINGSMAXes.FirstOrDefault(x => x.IDSS == sens.ID);

                    if (dv != null)
                    {

                        dv.SENSOR = null;
                        dv.IDSENSOR = sens.NAME;

                        if (double.Parse(sens.NUMBER) >= double.Parse(dv.VALUE))
                        {
                            lstWarnings.Add(dv);
                        }
                       
                    }
                }
            }

            return lstWarnings;

        }
    }
}
