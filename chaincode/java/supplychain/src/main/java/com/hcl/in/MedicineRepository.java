package com.hcl.in;
import com.owlike.genson.Genson;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.*;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;


@Contract(
        name = "Medicines",
        info = @Info(
                title = "Medicines contract",
                description = "A java chaincode example",
                version = "0.0.1-SNAPSHOT"))
                public Medicine(Long id, String name, String brandName, String genericName, List chemicals, double MRP, double dealerPrice, Owner owner) {
                    this.id = id;
                    this.name = name;
                    this.brandName = brandName;
                    this.genericName = genericName;
                    this.chemicals = chemicals;
                    this.MRP = MRP;
                    this.dealerPrice = dealerPrice;
                    this.owner = owner;
                }
@Default
    public final class MedicineRepository implements ContractInterface{
    private final Genson genson = new Genson();

    @Transaction()
    public void initLedger(final Context ctx) {
        ChaincodeStub stub = ctx.getStub();
        Address address = new Address(1, "SUN HOUSE", "CTS No. 201", "Goregaon", "Mumbai", "MAHARASTRA", "INDIA", "400063")
        Owner owner = new Owner(1, "SUN PHARMACEUTICAL", "MANUFACTURER", address)
        Medicine medicine = new Medicine(1, "ABSENZ ORAL SOLUTION 100ML", "ABSENZ", "Ethosuximide", ["X", "Y", "Z"], "SOLUTION", 99.00, 50.00, owner);

        String medicineState = genson.serialize(medicine);
        stub.putStringState("ARG001", medicineState);
    }


    @Transaction()
    public Agreement getMedicine(final Context ctx, final String key) {
        ChaincodeStub stub = ctx.getStub();
        String medicineState = stub.getStringState(key);

        if (medicineState.isEmpty()) {
            String errorMessage = String.format("Agreement %s does not exist", key);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, "Agreement not found");
        }

        Medicine medicine = genson.deserialize(medicineState, Medicine.class);

        return medicine;
    }

    @Transaction()
    // public Agreement createAgreement(final Context ctx, final String key, final String party1, final String party2,
    //                                 final String stats) {
    public Agreement createMedicine(final Context ctx, final Medicine medicine) {
        ChaincodeStub stub = ctx.getStub();

        String agreementState = stub.getStringState(key);
        if (!agreementState.isEmpty()) {
            String errorMessage = String.format("Agreement %s already exists", key);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, "Agreement already exists");
        }

        // Agreement agreement = new Agreement(party1, party2, stats);
        Address address = new Address(1, "SUN HOUSE", "CTS No. 201", "Goregaon", "Mumbai", "MAHARASTRA", "INDIA", "400063")
        Owner owner = new Owner(1, "SUN PHARMACEUTICAL", "MANUFACTURER", address)
        Medicine medicine = new Medicine(2, "ACAMPROL 333 MG TABLET 6", "ACAMPROL", "ACAMPROSATE", ["X", "Y", "Z"], "TABLET", 99.00, 50.00, owner);

        medicineState = genson.serialize(medicine);
        stub.putStringState(key, medicineState);

        return medicine;
    }


    @Transaction()
    public Agreement changeOwner(final Context ctx, final String key, final String newStatus) {
        ChaincodeStub stub = ctx.getStub();

        String agreementState = stub.getStringState(key);

        if (agreementState.isEmpty()) {
            String errorMessage = String.format("Agreement %s does not exist", key);
            System.out.println(errorMessage);
            throw new ChaincodeException(errorMessage, "Agreement not found");
        }

        Agreement agreement = genson.deserialize(agreementState, Agreement.class);

        Agreement newAgreement = new Agreement(agreement.getParty1(), agreement.getParty2(),newStatus);
        String newAgreementState = genson.serialize(newAgreement);
        stub.putStringState(key, newAgreementState);

        return newAgreement;
    }

}