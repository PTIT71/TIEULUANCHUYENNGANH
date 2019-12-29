using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WEBSERVICEAPI.Controllers
{
    public class MonitorController : ApiController
    {
        [HttpGet]
        public int GetStatus(string ID)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            MONITOR mnt = context.MONITORs.FirstOrDefault(x => x.ID == ID);

            return (int)mnt.STATUS;
        }


        [HttpPut]
        public bool UpdateStatus(string ID, int status)
        {
            try
            {
                AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
                MONITOR dv = context.MONITORs.FirstOrDefault(x => x.ID == ID);

                if (dv != null)
                {
                    dv.STATUS = status;
                    context.SubmitChanges();
                    return true;
                }
            }
            catch { }
            return false;
        }

        [HttpGet]
        public List<MONITOR> DanhSachDongCoCuaThietBi(string IDDV)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            List<DVMT> lstDeviceMonitor = context.DVMTs
                .Where(x => x.IDDV == IDDV)
                .ToList();

            var list = new List<DVMT>();

            foreach (var e in lstDeviceMonitor)
            {
                list.Add(new DVMT
                {
                    IDDV = e.IDDV,
                    IDMT = e.IDMT
                });
            }


            List<MONITOR> lstSensor = new List<MONITOR>();

            foreach (var item in lstDeviceMonitor)
            {
                MONITOR dv = context.MONITORs.FirstOrDefault(x => x.ID == item.IDMT);
                dv.DVMTs = null;
                dv.TYPE_MT = null;
                lstSensor.Add(dv);
            }
            return lstSensor;
        }
    }
}
