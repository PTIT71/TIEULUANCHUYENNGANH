using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WEBSERVICEAPI.Controllers
{
    public class SENSORController : ApiController
    {
        [HttpGet]
        public List<SENSOR> DanhSachCamBienCuaThietBi(string IDDV)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            List<DVSS> lstDeviceSenSor = context.DVSSes
                .Where(x => x.IDDV == IDDV)
                .ToList();

            var list = new List<DVSS>();
            
            foreach (var e in lstDeviceSenSor)
            {
                list.Add(new DVSS
                {
                    IDDV = e.IDDV,
                    IDSS = e.IDSS
                });
            }
            

            List<SENSOR> lstSensor = new List<SENSOR>();

            foreach (var item in lstDeviceSenSor)
            {
                SENSOR dv = context.SENSORs.FirstOrDefault(x => x.ID == item.IDSS);
                dv.DVSSes = null;
                dv.TYPE_SS = null;
                dv.WARNINGSMAXes = null;
               
                lstSensor.Add(dv);
            }
            return lstSensor;
        }

        [HttpPut]
        public bool UpdateStatus(string ID, string value)
        {
            try
            {
                AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
                SENSOR dv = context.SENSORs.FirstOrDefault(x => x.ID == ID);

                if (dv != null)
                {
                    dv.NUMBER = value;
                    context.SubmitChanges();
                    return true;
                }
            }
            catch { }
            return false;
        }
    }
}
