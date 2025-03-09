import {Speciality} from "./speciality";
import {AddressType} from "./enums/address-type";

export class Praticien {
  lastName?: string;
  firstName?: string;
  email?: string;
  phone?: string;
  specialities?: Speciality[];
  addressTypes?: AddressType[];
}
