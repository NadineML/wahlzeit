package org.wahlzeit.model;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class AnimalPhotoTest {
    @Test
    public void testCreateAnimalPhoto() {
        AnimalPhoto animalPhoto = new AnimalPhoto();
        assert(animalPhoto instanceof Photo);
        assert(animalPhoto instanceof AnimalPhoto);
    }

    @Test
    public void testGetAnimalPhotoFactoryInstance() {
        AnimalPhotoFactory photoFactory = AnimalPhotoFactory.getInstance();
        assertNotNull(photoFactory);
        assert(photoFactory instanceof AnimalPhotoFactory);
        assert(photoFactory instanceof PhotoFactory);
    }

    @Test
    public void testAnimalPhoto() {
        AnimalPhoto animalPhoto = new AnimalPhoto();
        assert(animalPhoto instanceof AnimalPhoto);
        assert(animalPhoto instanceof Photo);
    }

    @Test
    public void testGetAnimalPhotoManagerInstance() {
        PhotoManager photoManager = AnimalPhotoManager.getInstance();
        assertNotNull(photoManager);
        assert(photoManager instanceof AnimalPhotoManager);
    }

    @Test
    public void testAnimalPhotoManager() {
        AnimalPhotoManager photoManager = new AnimalPhotoManager();
        assertNotNull(photoManager.photoTagCollector);
    }

}
