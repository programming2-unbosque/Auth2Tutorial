package edu.unbosque.Auth2Tutorial;

import edu.unbosque.Auth2Tutorial.resources.OwnerResource;
import edu.unbosque.Auth2Tutorial.resources.VetResource;
import edu.unbosque.Auth2Tutorial.resources.filters.SecutiryFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class Auth2Application extends Application {
}