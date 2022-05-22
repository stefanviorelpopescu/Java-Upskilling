package class_design.composition;

import java.util.List;

public class LibraryMembership implements Membership
{
    private long id;
    private List<Long> locationIds;

    @Override
    public void addLocationMembership(long locationId) {

    }

    @Override
    public void revokeLocationMembership(long locationId) {

    }

}
