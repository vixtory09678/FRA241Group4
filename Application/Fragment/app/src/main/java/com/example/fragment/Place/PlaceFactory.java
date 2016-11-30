package com.example.fragment.Place;

/**
 * Created by Palmkongkiet on 11/15/2016.
 */

public class PlaceFactory {

    public static PlaceKmutt PlaceManager(String namePlace) {


        if ((namePlace.equalsIgnoreCase("สถาบันวิทยาการหุ่นยนต์ภาคสนาม - ฟีโบ้")) || (namePlace.equalsIgnoreCase("Institude of Field Robotics - FIBO"))) {
            return new FIBO();

        } else if ((namePlace.equalsIgnoreCase("อาคารเรียนรวม 1")) || (namePlace.equalsIgnoreCase("Classroom Building 1"))) {
            return new CB_1();

        } else if ((namePlace.equalsIgnoreCase("อาคารเรียนรวม 2")) || (namePlace.equalsIgnoreCase("Classroom Building 2"))) {
            return new CB_2();

        } else if ((namePlace.equalsIgnoreCase("อาคารเรียนรวม 3")) || (namePlace.equalsIgnoreCase("Classroom Building 3"))) {
            return new CB_3();

        } else if ((namePlace.equalsIgnoreCase("อาคารเรียนรวม 4")) || (namePlace.equalsIgnoreCase("Classroom Building 4"))) {
            return new CB_4();

        } else if ((namePlace.equalsIgnoreCase("อาคารเรียนรวม 5")) || (namePlace.equalsIgnoreCase("Classroom Building 5"))) {
            return new CB_5();

        } else if ((namePlace.equalsIgnoreCase("อาคารพระจอมเกล้าราชานุสรณ์ 190 ปี - โรงอาหาร")) || (namePlace.equalsIgnoreCase("King Mongkut Food Center"))) {
            return new KFC();

        } else if ((namePlace.equalsIgnoreCase("โรงเรียนดรุณสิกขาลัย")) || (namePlace.equalsIgnoreCase("Darunsikkhalai School"))){
            return new DarunSchool();

        } else if ((namePlace.equalsIgnoreCase("อาคารวิศววัฒนะ")) || (namePlace.equalsIgnoreCase("ตึกแดง")) || (namePlace.equalsIgnoreCase("Engineering Building"))){
            return new EnBuilding();

        } else if ((namePlace.equalsIgnoreCase("อาคารวิศวกรรมเคมี")) || (namePlace.equalsIgnoreCase("Chemical Engineer Building"))){
            return new ChemEN();

        } else if ((namePlace.equalsIgnoreCase("บ้านธรรมรักษา 1 - หอชาย")) || (namePlace.equalsIgnoreCase("Domitory Male"))){
            return new DomMale();

        } else if ((namePlace.equalsIgnoreCase("บ้านธรรมรักษา 2 - หอหญฺิง")) || (namePlace.equalsIgnoreCase("Domitory Female"))){
            return new DomFemale();

        } else if (namePlace.equalsIgnoreCase("อาคารจอดรถสูง 14 ชั้น")){
            return new CarPark14();

        } else if ((namePlace.equalsIgnoreCase("อาคารสำนักงานอธิการบดี")) || (namePlace.equalsIgnoreCase("Office of The President"))){
            return new PresidentOffice();

        } else if ((namePlace.equalsIgnoreCase("อาคารเรียนและปฏิบัติการคณะพลังงานและสิ่งแวดล้อมและวัสดุ")) || (namePlace.equalsIgnoreCase("School of Energy, Environment and Materials"))){
            return new EnergySchool();

        } else if ((namePlace.equalsIgnoreCase("อาคารโรงประลองเทคโนโลยีและวัสดุ")) || (namePlace.equalsIgnoreCase("Energy and Materials Workshop"))){
            return new EnergyWorkshop();

        } else if (namePlace.equalsIgnoreCase("อาคารอเนกประสงค์")){
            return new NewBuilding();

        } else if ((namePlace.equalsIgnoreCase("อาคารศิลปศาสตร์")) || (namePlace.equalsIgnoreCase("School of Liberal Arts"))){
            return new LiberalArts();

        } else if ((namePlace.equalsIgnoreCase("อาคารภาควิชาเคมี")) || (namePlace.equalsIgnoreCase("Chemistry Department Building"))){
            return new ChemDeparment();

        } else if ((namePlace.equalsIgnoreCase("อาคารภาควิชาฟิสิกส์")) || (namePlace.equalsIgnoreCase("Department of Physics Building"))){
            return new PhysicDepartment();

        } else if ((namePlace.equalsIgnoreCase("อาคารภาควิชาคณิตศาสตร์")) || (namePlace.equalsIgnoreCase("Department of Mathematics Building"))){
            return new MathDepartment();

        } else if ((namePlace.equalsIgnoreCase("อาคารศูนย์เครื่องมือวิทยาศาสตร์")) || (namePlace.equalsIgnoreCase("Scientic Instrumentation Center"))){
            return new SciCenter();

        } else if ((namePlace.equalsIgnoreCase("อาคารภาควิชาจุลชีววิทยา")) || (namePlace.equalsIgnoreCase("Microbiology Building"))){
            return new MicroBiology();

        } else if ((namePlace.equalsIgnoreCase("อาคารปฏิบัติการพื้นฐานทางวิทยาศาสตร์")) || (namePlace.equalsIgnoreCase("Fundamental Science Laboratory Building"))){
            return new SciLabBuilding();

        } else if ((namePlace.equalsIgnoreCase("สำนักหอสมุด")) || (namePlace.equalsIgnoreCase("Library Building"))){
            return new Library();

        } else if ((namePlace.equalsIgnoreCase("อาคารคณะเทคโนโลยีสารสนเทศ")) || (namePlace.equalsIgnoreCase("School of Information Technology - SIT"))){
            return new SIT();

        } else {
            return null;
        }


    }

}
