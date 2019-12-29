using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WEBSERVICEAPI.Controllers
{
    public class DeviceController : ApiController
    {
        [HttpPost]
        public bool LuuDevice(string id, string partcode, string name, int status)
        {
            try
            {
                AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
                DEVICE dv = new DEVICE();
                dv.ID = id;
                dv.NAME = name;
                dv.STATUS = status;
                dv.PARTCODE = partcode;
                context.DEVICEs.InsertOnSubmit(dv);
                context.SubmitChanges();
                return true;
            }
            catch
            {

            }
            return false;
        }

        [HttpGet]
        public DEVICE SearchID(string PartCode)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            DEVICE device = context.DEVICEs.FirstOrDefault(x => x.PARTCODE == PartCode);

            USR_DV usr_dv = context.USR_DVs.FirstOrDefault(x => x.IDDV == device.ID);

            if(usr_dv != null)
            {
                device.ID = null;
            }

            return device;
        }

        [HttpGet]
        public DEVICE SearchIDs(string ID)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            DEVICE device = context.DEVICEs.FirstOrDefault(x => x.ID == ID);

            USR_DV usr_dv = context.USR_DVs.FirstOrDefault(x => x.IDDV == device.ID);

            if (usr_dv != null)
            {
                device.ID = null;
                
            }

            return device;
        }

        [HttpPut]
        public bool UpdateStatus(string ID, int status)
        {
            try
            {
                AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
              

                DEVICE dv = context.DEVICEs.FirstOrDefault(x => x.ID == ID);

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
    }
}
