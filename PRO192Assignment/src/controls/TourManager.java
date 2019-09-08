package controls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import model.BaseTour;
import model.DomesticTours;
import model.ITour;
import model.InternationalTours;

public class TourManager {
	static class MyStoreData implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Set<String> codeExists;
		private List<BaseTour> tours;

		public MyStoreData(Set<String> codeExists, List<BaseTour> tours) {
			super();
			this.codeExists = codeExists;
			this.tours = tours;
		}

	}

	private static final Scanner sc = new Scanner(System.in);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static final String PATH_STORE = "store.txt";

	private Set<String> codeExists;
	private List<BaseTour> tours;

	public TourManager() {
		super();
		tours = new ArrayList<>();
		codeExists = new HashSet<>();
	}

	private void addNewTour() {
		while (true) {
			try {
				showSubMenuNewTour();
				int chooseId = Integer.parseInt(sc.nextLine().trim());
				if (!handleSubMenuNewTour(chooseId)) {
					break;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	private void computeAverageInternationalTour() {
		double sum = 0;
		int count = 0;

		for (BaseTour baseTour : tours) {
			if (baseTour instanceof InternationalTours) {
				sum += baseTour.computeTourCharge();

				++count;
			}
		}
		System.out.println("average tour charge of all international: " + (count == 0 ? "0" : sum / count));
	}

	private void displayAllDomesticTour() {
		System.out.println("---");
		for (BaseTour baseTour : tours) {
			if (baseTour instanceof DomesticTours) {
				System.out.println(baseTour);
			}
		}
		System.out.println("---");
	}

	private void displayAllTour() {
		System.out.println("---");
		for (ITour tour : tours) {
			System.out.println(tour);
		}
		System.out.println("---");
	}

	private void handleMainMenu(int chooseId) {
		switch (chooseId) {
		case 0:
			System.out.println("Bye!");
			System.exit(0);
		case 1:
			addNewTour();
			break;
		case 2:
			displayAllDomesticTour();
			break;
		case 3:
			computeAverageInternationalTour();
			break;
		case 4:
			searchTour();
			break;
		case 5:
			removeTourByCode();
			break;
		case 6:
			sortTour();
			break;
		case 7:
			updateTour();
			break;
		case 8:
			saveLoadFile();
			break;

		case 9:
			displayAllTour();
			break;

		default:
			System.out.println("???");
		}

	}

	private boolean handleSubMenuNewTour(int chooseId) throws ParseException {
		if (chooseId == 0) {
			return false;
		}

		if (chooseId == 1 || chooseId == 2) {
			BaseTour tour;
			System.out.println("ENTER: ");

			System.out.println("code: ");
			String code = sc.nextLine();

			if (codeExists.contains(code)) {
				System.out.println("Code " + code + " already exists!");
				return true;
			}

			System.out.println("title: ");
			String title = sc.nextLine();
			System.out.println("price: ");
			double price = Double.parseDouble(sc.nextLine().trim());
			System.out.println("transport: ");
			String transport = sc.nextLine();
			System.out.println("start date: ");
			Date startDate = sdf.parse(sc.nextLine().trim());
			System.out.println("end date: ");
			Date endDate = sdf.parse(sc.nextLine().trim());

			if (chooseId == 1) {
				double tourGuideTip;
				System.out.println("tourGuideTip: ");
				tourGuideTip = Double.parseDouble(sc.nextLine().trim());
				tour = new DomesticTours(code, title, price, transport, startDate, endDate, tourGuideTip);
			} else {
				System.out.println("aviation Tax");
				double aviationTax = Double.parseDouble(sc.nextLine().trim());
				System.out.println("Entry Fee");
				double entryFee = Double.parseDouble(sc.nextLine().trim());
				tour = new InternationalTours(code, title, price, transport, startDate, endDate, aviationTax, entryFee);
			}

			tours.add(tour);
			codeExists.add(code);
			System.out.println("Add success!");
		} else {
			System.out.println("???");
		}
		return true;
	}

	private boolean handleSubMenuSaveLoadFile(int chooseId) throws IOException, ClassNotFoundException {
		if (chooseId == 0) {
			return false;
		}

		if (chooseId == 1 || chooseId == 2) {
			if (chooseId == 1) {
				saveToFile();
			} else {
				loadFromFile();
			}

		} else {
			System.out.println("???");
		}
		return true;
	}

	private boolean handleSubMenuSearchTour(int chooseId) {
		if (chooseId == 0) {
			return false;
		}

		if (chooseId > 0 || chooseId < 6) {
			List<BaseTour> list;
			if (chooseId == 1) {
				list = searchByCode();
			} else if (chooseId == 2) {
				list = searchByTitle();
			} else if (chooseId == 3) {
				list = searchByStartDate();
			} else if (chooseId == 4) {
				list = searchByTransport();
			} else {
				list = searchByMinimumTourCharge();
			}
			if (list != null && !list.isEmpty()) {
				System.out.println("---");
				for (BaseTour baseTour : list) {
					System.out.println(baseTour);
				}
				System.out.println("---");
			}

		} else {
			System.out.println("???");
		}
		return true;
	}

	private boolean handleSubMenuUpdateTour(int chooseId) throws ParseException {
		if (chooseId == 0) {
			return false;
		}

		if (chooseId == 1 || chooseId == 2) {
			BaseTour tour;
			System.out.println("ENTER: ");

			System.out.println("code to update: ");
			String code = sc.nextLine();

			if (!codeExists.contains(code)) {
				System.out.println("Code " + code + " not already exists!");
				return true;
			}

			System.out.println("title: ");
			String title = sc.nextLine();
			System.out.println("price: ");
			double price = Double.parseDouble(sc.nextLine().trim());
			System.out.println("transport: ");
			String transport = sc.nextLine();
			System.out.println("start date: ");
			Date startDate = sdf.parse(sc.nextLine().trim());
			System.out.println("end date: ");
			Date endDate = sdf.parse(sc.nextLine().trim());

			if (chooseId == 1) {
				double tourGuideTip;
				System.out.println("tourGuideTip: ");
				tourGuideTip = Double.parseDouble(sc.nextLine().trim());
				tour = new DomesticTours(code, title, price, transport, startDate, endDate, tourGuideTip);
			} else {
				System.out.println("aviation Tax");
				double aviationTax = Double.parseDouble(sc.nextLine().trim());
				System.out.println("Entry Fee");
				double entryFee = Double.parseDouble(sc.nextLine().trim());
				tour = new InternationalTours(code, title, price, transport, startDate, endDate, aviationTax, entryFee);
			}

			tours.replaceAll(t -> {
				if (t.getCode().equals(code)) {
					return tour;
				}
				return t;
			});
			System.out.println("update success!");
		} else {
			System.out.println("???");
		}
		return true;
	}

	private void loadFromFile() throws IOException, ClassNotFoundException {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_STORE))) {
			Object object = ois.readObject();
			if (object instanceof MyStoreData) {
				MyStoreData storeData = (MyStoreData) object;
				if (storeData.tours != null && storeData.codeExists != null) {
					tours = storeData.tours;
					codeExists = storeData.codeExists;
				}
				System.out.println("load success");
			} else {
				throw new IOException("Invalid data");
			}
		}

	}

	private void removeTourByCode() {
		System.out.print("Remove code: ");
		String code = sc.nextLine();
		boolean b = tours.removeIf(t -> t.getCode().equals(code));
		if (b) {
			System.out.println("Removing...!");
			codeExists.remove(code);
			System.out.println("Remove Success!");
		} else {
			System.out.println("Nothing to remove!!");
		}
	}

	public void run() {
		while (true) {
			try {
				showMenu();
				int chooseId = Integer.parseInt(sc.nextLine().trim());
				handleMainMenu(chooseId);
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

	private void saveLoadFile() {
		while (true) {
			try {
				showSubMenuSaveLoadFile();
				int chooseId = Integer.parseInt(sc.nextLine().trim());
				if (!handleSubMenuSaveLoadFile(chooseId)) {
					break;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

	private void saveToFile() throws IOException {
		File file = new File(PATH_STORE);
		if (!file.exists()) {
			file.createNewFile();
		}

		file.setWritable(true);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(new MyStoreData(codeExists, tours));
		}
		file.setWritable(false);
		System.out.println("Save Success!");
	}

	private List<BaseTour> searchByCode() {
		List<BaseTour> list = new ArrayList<>();

		System.out.print("search code: ");
		String code = sc.nextLine();
		for (BaseTour baseTour : tours) {
			if (baseTour.getCode().equals(code)) {
				list.add(baseTour);
			}
		}
		return list;
	}

	private List<BaseTour> searchByMinimumTourCharge() {
		List<BaseTour> list = new ArrayList<>(tours);// clone list
		list.sort((o1, o2) -> Double.compare(o1.computeTourCharge(), o2.computeTourCharge()));// sort by money asc
		return list;
	}

	private List<BaseTour> searchByStartDate() {
		List<BaseTour> list = new ArrayList<>(tours);// clone list
		list.sort((o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
		return list;
	}

	private List<BaseTour> searchByTitle() {
		List<BaseTour> list = new ArrayList<>();

		System.out.print("search title: ");
		String title = sc.nextLine();
		for (BaseTour baseTour : tours) {
			if (baseTour.getTitle().equals(title)) {
				list.add(baseTour);
			}
		}
		return list;
	}

	private List<BaseTour> searchByTransport() {
		List<BaseTour> list = new ArrayList<>();

		System.out.print("search transport: ");
		String transport = sc.nextLine();
		for (BaseTour baseTour : tours) {
			if (baseTour.getTransport().equals(transport)) {
				list.add(baseTour);
			}
		}
		return list;
	}

	private void searchTour() {
		while (true) {
			try {
				showSubMenuSearchTour();
				int chooseId = Integer.parseInt(sc.nextLine().trim());
				if (!handleSubMenuSearchTour(chooseId)) {
					break;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	private void showMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Add new tour");
		System.out.println("2. List all domestic tours in the system");
		System.out.println("3. Compute the average tour charge of all international tours");
		System.out.println("4. Search tour");
		System.out.println("5. Remove the tour having given code");
		System.out.println(
				"6. Sort all tours of list by multiple levels in descending order of tour’s price and then in ascending order of tour’s title");
		System.out.println("7. Update tour information");
		System.out.println("8. Save/ Load tours to/ from file");
		System.out.println("9. Display all tour");
		System.out.println("0. Exit");
		System.out.print("> ");

	}

	private void showSubMenuNewTour() {
		System.out.println("-------");
		System.out.println("1. Add new domestic tours");
		System.out.println("2. Add new international tours");
		System.out.println("0. Back");
	}

	private void showSubMenuSaveLoadFile() {
		System.out.println("-------");
		System.out.println("1. Save to file");
		System.out.println("2. Load from file");
		System.out.println("0. Back");
	}

	private void showSubMenuSearchTour() {
		System.out.println("-------");
		System.out.println("1. By tour’s code");
		System.out.println("2. By title");
		System.out.println("3. By start date");
		System.out.println("4. By transport");
		System.out.println("5. By minimum tour charge");
		System.out.println("0. Back");
	}

	private void showSubMenuUpdateTour() {
		System.out.println("-------");
		System.out.println("1. Update domestic tours");
		System.out.println("2. Update international tours");
		System.out.println("0. Back");
	}

	private void sortTour() {
		tours.sort((o1, o2) -> {
			int x = Double.compare(o2.getPrice(), o1.getPrice());
			if (x == 0) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
			return x;
		});
	}

	private void updateTour() {

		while (true) {
			try {
				showSubMenuUpdateTour();
				int chooseId = Integer.parseInt(sc.nextLine().trim());
				if (!handleSubMenuUpdateTour(chooseId)) {
					break;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}
}
